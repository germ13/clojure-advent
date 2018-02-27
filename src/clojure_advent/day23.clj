(ns day23)

(def direction [
    [  1  0 ]
    [  0  1 ]
    [ -1  0 ]
    [  0 -1 ]
])

(defn move [location heading]
      [ (+ (first location) (first (nth direction (mod heading 4))))
        (+ (second location) (second (nth direction (mod heading 4))))])

;; counter         : '(1 2 3 5 7 10 13 17 21 26 31 37 43 50 57)
;; delta (gnomon)  : '(  1 1 2 2  3  3  4  4  5  5  6  6  7  7)

(defn turn-point? [counter delta]
  (if (or (= (+ (* delta delta) 1) counter)
          (= (+ (* delta delta) (+ delta 1)) counter))
    true
    false))

(defn increase-delta? [counter delta]
  (if (= (+ (* delta delta) (+ delta 1)) counter)
    true
    false))


(defn ulam [endpoint]
  (loop [
          counter 1
          current-coordinates [0 0]
          heading 0
          delta 1
          ]
    (if (= counter endpoint)
      current-coordinates
      (recur
        ;; counter
        (inc counter)
        ;; coordinates
        (move current-coordinates heading)
        ;; heading
        (if (turn-point? counter delta)
          (mod (inc heading) 4)
          heading)
        ;; delta
        (if (increase-delta? counter delta)
          (inc delta)
          delta)))))


(defn neighbor-sum [x]
  x)


(defn ulam2 [endpoint]
  (loop [
          counter 1
          current-coordinates [0 0]
          heading 0
          delta 1
          value-at-counter 1
          coordinates-visited []
          ]
    (if (= counter endpoint)
      current-coordinates
      (recur
        ;; counter
        (inc counter)
        ;; coordinates
        (move current-coordinates heading)
        ;; heading
        (if (turn-point? counter delta)
          (mod (inc heading) 4)
          heading)
        ;; delta
        (if (increase-delta? counter delta)
          (inc delta)
          delta)
        ;; value-at-counter


        ;; coordinates-visited
        (conj coordinates-visited [current-coordinates (value-at-coordinate coordinates-visited coord)])
        ))))


(defn ulam-inverse [endpoint-coordinates]
  (loop [counter 1
         ]
    (if (= (ulam counter) endpoint-coordinates)
      counter
      (recur (inc counter)))))


(defn value-at-coordinate [collection coordinate]
  (last
    (last
      (filter #(= (first %) coordinate) collection))))



(def test
[  [ [ 0 0 ] 1 ]
   [ [ 1 0 ] 1 ]
   [ [ 0 1 ] 2 ]
   [ [-1 1 ] 4 ] ])



(ulam-inverse [5,5])
(value-at-coordinate test [0 1])



(defn value-at-counter [ coord coordinates-visited ]
  1)

