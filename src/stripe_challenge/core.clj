(ns stripe-challenge.core)

(defn next-server-number [all-servers]
  (next-server-number-3 all-servers))

(defn next-server-number-1
  [all-servers]
  (let [all-servers (sort all-servers)]
    (loop [servers all-servers]
      (cond (= 0 (count servers))
            1
            (= 1 (count servers))
            (if (= 1 (first all-servers))
              (+ (last all-servers) 1)
              (- (first all-servers) 1))
            :else
            (let [current-server (first servers)]
              (if (= current-server (- (second servers)
                                       1))
                (recur (rest servers))
                (+ current-server 1)))))))

(defn next-server-number-2
  [all-servers]
  (cond
    (= 0 (count all-servers))
    1
    (= 1 (count all-servers))
    (if (= 1 (first (sort all-servers)))
      (+ (last (sort all-servers)) 1)
      (- (first (sort all-servers)) 1))
    :else
    (let [sorted-servers (sort (set all-servers))]
      (reduce (fn [a b]
                (cond (and (= b (last sorted-servers))
                           (< 1 (first sorted-servers)))
                      (- (first sorted-servers) 1)
                      (or (nil? b)
                          (= b (last sorted-servers)))
                      (+ (last sorted-servers) 1)
                      (not= (+ a 1) b)
                      (reduced (+ a 1))
                      :else
                      b))
              sorted-servers))))

(defn next-server-number-3
  [all-servers]
  (let [all-servers   (apply sorted-set all-servers)
        server-count  (count all-servers)
        servers-range (apply sorted-set (range (or (first all-servers)) server-count))
        difference    (clojure.set/difference servers-range
                                              all-servers)]
    (if (empty? difference)
      (if (= 1 (first all-servers))
        (+ 1 (last all-servers))
        (- (first all-servers) 1))
      (first difference))))



(comment
  (apply sorted-set [])

  (next-server-number-3 (set [1 2 3 5 6]))

  (next-server-number-3 [])

  (first [])


  (def all-servers (apply sorted-set [3 2 1]))

  (def server-count (count all-servers))

  (def servers-range (apply sorted-set (range (first all-servers) server-count)))


  all-servers


  servers-range



  (range 1 3)
  )
