import           Control.Monad (liftM2)
import           Data.Char     (toLower)
import           Data.List     (intersperse)

-- Datas
data Language=Imp -- Boa|BoaAllDispatch|Petrinet|Logo|LogoAllDispatch
  deriving (Show)

languages :: [Language]

data Program = Program {
  language :: Language,
  name     :: String
} deriving (Show)

data Runtime=Graalvm|GraalvmTruffle -- |Java8|OpenJ9
  deriving (Show)

data CompileTarget=Interpreter|Truffle -- |Visitor|Revisitor|Switch
  deriving (Show)

type Programs = [Program]

-- methods
runtimeToVar :: Runtime -> String
runtimeToVar Graalvm        = "$GRAALVM_HOME"
runtimeToVar GraalvmTruffle = "$GRAALVM_HOME"
--runtimeToVar Java8          = "$JAVA8_HOME"
--runtimeToVar OpenJ9         = "$OPENJ9_HOME"


flattenedtargets :: Foldable t2 => t2 (t, [t1]) -> [(t, t1)]
flattenedtargets targets = concatMap (\(ct, rts) -> map (\x -> (ct,x)) rts) targets

p :: Language -> String -> Program
p = Program

combine :: [a] -> [b] -> [(a,b)]
combine = liftM2 (,)

tojarName :: (Language, CompileTarget) -> String
tojarName (l, ct) = map toLower $ show l ++ "_" ++ show ct ++ ".jar"

fullname :: CompileTarget -> Runtime -> Program -> String
fullname ct r p' = map toLower $ show ct ++ "_" ++ show r ++ "_" ++ show (language p') ++ "_" ++ name p'

logname :: ((CompileTarget, Runtime), Program) -> String
logname ((ct, r), p') = fullname ct r p' ++ ".log"

toExecution :: ((CompileTarget, Runtime), Program) -> String
toExecution t@((ct, GraalvmTruffle), p') = unlines [
    "echo \"" ++ fullname ct GraalvmTruffle p' ++ "\""
  , lastLineAndSave  command file ]
  where command = runtimeToVar GraalvmTruffle ++ "/bin/java -XX:-UseJVMCIClassLoader -jar " ++ tojarName (language p', ct) ++ " " ++ name p' ++ ".xmi" ++  " " ++ "$ITERATIONS"
        file = logname t
toExecution t@((ct, r), p') = unlines [
    "echo \"" ++ fullname ct r p' ++ "\""
  , lastLineAndSave command file ]
  where command = runtimeToVar r ++ "/bin/java -jar " ++ tojarName (language p', ct) ++ " " ++ name p' ++ ".xmi" ++  " " ++ "$ITERATIONS"
        file = logname t

lastLineAndSave :: String -> String -> String
lastLineAndSave command file = command ++ " | tail -n1 > " ++ file

toCheckFile :: Language -> CompileTarget -> String
toCheckFile ct r = unlines [
    "if [ ! -f \"" ++ tojarName (ct, r) ++ "\" ]; then"
  , "  echo \"File " ++ tojarName (ct, r) ++ " does not exist.\""
  , "  exit 1"
  , "fi"
  ]

-- configuration
compilerTargets :: [CompileTarget]
compilerTargets = [ Interpreter, Truffle] -- Visitor, Revisitor, , Switch

targets :: [(CompileTarget, [Runtime])]
targets = [
    --(Visitor, [Graalvm, Java8, OpenJ9])
  --, (Revisitor, [Graalvm, Java8, OpenJ9])
  --,
  (Interpreter, [Graalvm]) -- , Java8, OpenJ9
  --, (Switch, [Graalvm, Java8, OpenJ9])
  , (Truffle, [GraalvmTruffle])
  ]

languages = [Imp] --Logo,  Boa, Petrinet,

programs :: Programs
programs = [
  p Imp "bubble"
  --p Logo "fractal",
  --p LogoAllDispatch "fractal"
  -- p Boa "fib20",
  -- p Boa "fib30",
  -- p BoaAllDispatch "fib20",
  -- p BoaAllDispatch "fib30"
  --, p Petrinet "manyToOne", p Petrinet "oneToOne",
  ]

printResult :: ((CompileTarget, Runtime), Program) -> String
printResult x@((ct, r), p') = unlines [
    "echo -n \"" ++ fullname ct r p' ++ "=\""
  , "tail -n1 " ++ logname x
  ]

results :: [((CompileTarget, Runtime), Program)] -> String
results xs = "results = {" ++ unwords (intersperse "," $ map result xs) ++ "}"
  where result ((ct, r), p')= "\""++ fn ct r p' ++"\": " ++ fn ct r p'
        fn = fullname

printResults :: [((CompileTarget, Runtime), Program)] -> String
printResults x = unlines (map printResult x ++ ["echo "++show (results x)])

setifnull :: String -> String -> String
setifnull key value = "if [ -z ${" ++ key ++ "+x} ]; then " ++ key ++ "=" ++ value ++ "; fi"

printkeyvalue :: String -> String
printkeyvalue key = "echo -n " ++ key ++ "=; echo $" ++ key

checkdirexists :: String -> String
checkdirexists dir = "if [ ! -d \"$" ++ dir ++ "\" ]; then echo " ++ dir ++ "=$"++dir++" does not exist; exit 1 ; fi"

main :: IO ()
main = do
  putStrLn $ setifnull "JAVA8_HOME" "$PWD/java-8-oracle"
  putStrLn $ setifnull "GRAALVM_HOME" "$PWD/graalvm-ee-1.0.0-rc9"
  putStrLn $ setifnull "OPENJ9_HOME" "$PWD/openj9-9-0.11.0"
  putStrLn $ setifnull "ITERATIONS" "100"
  putStrLn $ checkdirexists "JAVA8_HOME"
  putStrLn "echo SUMMARY:"
  putStrLn $ printkeyvalue "JAVA8_HOME"
  putStrLn $ printkeyvalue "GRAALVM_HOME"
  putStrLn $ printkeyvalue "OPENJ9_HOME"
  putStrLn $ printkeyvalue "ITERATIONS"
  putStrLn "# Jar names:"
  let c = combine languages compilerTargets
  let strs = map (uncurry toCheckFile) c
  mapM_ putStrLn strs
  let x = combine (flattenedtargets targets) programs
  putStrLn "# Executions:"
  mapM_ (putStrLn .  toExecution) x
  let total = 500 * length x
  putStrLn $ "# Total executions " ++ show total
  putStrLn $ printResults x
