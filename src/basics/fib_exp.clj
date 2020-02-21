(ns basics.fib-exp)

(defn fib [n]
   (if (<= n 2)
     1
     (+ (fib (dec n))
        (fib (dec(dec n))))))

(def fib (memoize fib))

