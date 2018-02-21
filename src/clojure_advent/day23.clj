(ns day23)

(def direction [
    [  1  0 ]
    [  0  1 ]
    [ -1  0 ]
    [  0 -1 ]
])

(direction 1)





(defn move [location heading]
      [ (+ (first location) (first (nth direction (mod heading 4))))
        (+ (second location) (second (nth direction (mod heading 4))))])


(move [3 3] 0)
(move [3 3] 1)
(move [3 3] 2)
(move [3 3] 3)


(def endpoint 14)
(loop [
        counter 1
        current-coordinates [0 0]
        movement 0
        scalar 2
        increase-scalar 0]
  (if (= counter endpoint)
    current-coordinates
    (recur (inc counter)
           (move current-coordinates movement)
           (if (= increase-scalar scalar) (inc movement) movement)
           (if (= increase-scalar scalar) (inc scalar) scalar)
           (mod (inc increase-scalar) scalar))))
