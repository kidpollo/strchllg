(ns stripe-challenge.core-test
  (:require [clojure.test :refer :all]
            [stripe-challenge.core :refer :all]))

(deftest next-server-number-test
  (testing ""
    (is (= 2 (next-server-number [5 3 1])))
    (is (= 3 (next-server-number [5 4 1 2])))
    (is (= 3 (next-server-number [6 5 4 2])))
    (is (= 4 (next-server-number [3 2 1])))
    (is (= 1 (next-server-number [2 3])))
    (is (= 2 (next-server-number [3 4])))
    (is (= 1 (next-server-number [2])))
    (is (= 2 (next-server-number [1])))
    (is (= 1 (next-server-number [])))))
