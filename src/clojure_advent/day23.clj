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

(mod 7 4)
(def endpoint 5)

(loop [
        counter 1
        current-coordinates [0 0]
        heading 0
        submovement 1
        increase-delta 2]
  (if (= counter 6)
    current-coordinates
    (recur (inc counter)                               ;; counter
           (move current-coordinates heading)         ;; current coordinates
           (if (= (mod increase-delta submovement) 0) (mod (inc heading) 4) heading) ;; heading
           (if (> submovement increase-delta ) 1 (inc submovement)) ;; submovement
           (if (> submovement increase-delta) (* 2 increase-delta) increase-delta))))  ;; increasedelta


