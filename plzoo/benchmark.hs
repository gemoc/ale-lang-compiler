import           Control.Monad (liftM2)
import           Data.Char     (toLower)

data Language=Boa|Petrinet|Logo deriving (Show)

languages :: [Language]
languages = [Boa, Petrinet, Logo]

data Program = Program {
  language :: Language,
  name     :: String
} deriving (Show)

data Runtime=Graalvm|Java8 deriving (Show)

runtimeToVar :: Runtime -> [Char]
runtimeToVar Graalvm = "$GRAALVM_HOME"
runtimeToVar Java8   = "$JAVA8_HOME"

data CompileTarget=Visitor|Revisitor|Interpreter|Truffle deriving (Show)

compilerTargets :: [CompileTarget]
compilerTargets = [Visitor, Revisitor, Interpreter] -- Truffle

targets :: [(CompileTarget, [Runtime])]
targets = [(Visitor, [Graalvm, Java8]), (Revisitor, [Graalvm, Java8]), (Interpreter, [Graalvm, Java8])] -- ,(Truffle, [Graalvm])

flattenedtargets :: [(CompileTarget, Runtime)]
flattenedtargets = concatMap (\(ct, rts) -> map (\x -> (ct,x)) rts) targets

p :: Language -> String -> Program
p = Program

type Programs = [Program]


-- TODO: add different kind of programes in BOA
programs :: Programs
programs = [
  p Boa "fib10", p Boa "fib20", p Petrinet "manyToOne", p Petrinet "oneToOne", p Logo "fractal"
  ]


combine :: [a] -> [b] -> [(a,b)]
combine = liftM2 (,)


tojarName :: (Language, CompileTarget) -> String
tojarName (l, ct) = map toLower $ show l ++ "-" ++ show ct ++ ".jar"

logname :: ((CompileTarget, Runtime), Program) -> String
logname t@((ct, r), p) = map toLower $ show ct ++ "-" ++ show r ++ "-" ++ show (language p) ++ "-" ++ name p ++ ".log"

toExecution :: (Num a, Show a) => ((CompileTarget, Runtime), Program) -> a -> String
toExecution t@((ct, r), p) itt = runtimeToVar r ++ "/bin/java -jar " ++ tojarName (language p, ct) ++ " " ++ name p ++ ".xmi" ++  " " ++ show itt ++ " "++ " > " ++ logname t

toComment :: [Char] -> [Char]
toComment a = "# " ++ a

toCheckFile :: Language -> CompileTarget -> String
toCheckFile ct r = unlines [
      "if [ ! -f \"" ++ tojarName (ct, r) ++ "\" ]; then"
    , "  echo \"File " ++ tojarName (ct, r) ++ " does not exist.\""
    , "  exit 1"
    , "fi"
  ]

main :: IO ()
main = do
  putStrLn "JAVA8_HOME=/usr/lib/jvm/java-8-oracle"
  putStrLn "GRAALVM_HOME=$HOME/jdk/graalvm-ee-1.0.0-rc7"
  putStrLn "# Jar names:"
  let c = combine languages compilerTargets
  let strs = map (\(l, ct) -> toCheckFile l ct) c
  mapM_ putStrLn strs
  let x = map (\x -> toExecution x 500) $ combine flattenedtargets programs
  putStrLn "# Executions:"
  mapM_ putStrLn x
  let total = 500 * length x
  putStrLn $ "# Total executions " ++ show total
