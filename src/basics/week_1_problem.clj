(ns basics.week-1-problem)

;; seconds in a year

(def year 2000)

(if (and (= (mod year 4) 0) (not= (mod year 100) 0))
  (* 366 24 60 60)
  (* 365 24 60 60))

;; sum of 1+2+...+n


(loop [iter 1
       acc 0]
  (if (> iter 100)
    (println acc)
    (recur (inc iter) (+ acc iter))
    )
  )