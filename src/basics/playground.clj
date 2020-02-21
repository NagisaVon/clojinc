(ns basics.playground)

(def shit-pile [1 1 2 4 5 10])

(distinct shit-pile)

; random 0-1 number
(rand-int 2)


;; Generate 100 digits of random 0 or 1


;; '#' like a lambda expression
(repeatedly 20 #(rand-int 2))

;; short version
(map #(* % 4)[1 2 3])

;; not short version
(defn a-func [x] (* x 4) )
(map a-func [1 2 3])


;; reduce filter con map
;; super powerful
;; reduce take a function and a argument
;; how this could be more easier ……………………

(reduce + (range 1 101))



(reduce + shit-pile)

;; ?
(reduce)

;; loop - recur structure
(loop [i 0]
  (if (< 5 i)
    (recur (inc i))
    ;;return
    (print :done!) ))


(def fab-seq
  ((fn feq-recur [a b]
     )

   0 1)

  )

;; for is like for-in
(def new-shit (for [shit shit-pile] (+ shit 1)))



(map inc (1 2 3)) ;; no, this will call func 1 with args 2 3
(map inc '(1 2 3))

(map * '(1 2 3) '(4 5 6))

(list 3) ;; this returns a list

(reduce list '(1 2 3 4 5)) ;; this is how reduce works


