(ns clj-grpc-demo.client-test
  (:require [clj-grpc-demo.client :as sut]
            [clojure.test :refer :all]
            [clj-grpc-demo.server :as sus]))



(deftest test-client
  (sus/start-server 43434)
  (is (= 3 (sut/add 1 2)))
  (is (= 13 (sut/subtract 14 1)))
  (sus/stop-server))



