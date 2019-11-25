f :: Num t => [[t]] -> [[t]]
f [] = [[0],[1]]
f x  = map (\y -> y ++ [1]) x ++ map (\y -> y ++ [0]) (reverse x)

main :: IO ()
main = do print $ f []
          print $ f . f $ []
          print $ f . f . f $ []
          print $ f . f . f . f $ []
