(ns clj-grpc-demo.server
  (:gen-class)
  (:import [io.grpc.calculator EqResponse]
           [io.grpc Server ServerBuilder]))

(defonce server nil)

(def server-port 55555)

(defn calculator-service []
  (proxy [io.grpc.calculator.CalculatorGrpc$CalculatorImplBase] []

    (add [^io.grpc.calculator.EqRequest req
          ^io.grpc.calculator.EqResponse res]
      (let [result (+ (.getVar1 req) (.getVar2 req))]
        (doto res
          (.onNext (-> (EqResponse/newBuilder)
                       (.setResult result)
                       (.build)))
          (.onCompleted))))

    (subtract [^io.grpc.calculator.EqRequest req
               ^io.grpc.calculator.EqResponse res]
      (let [result (- (.getVar1 req) (.getVar2 req))]
        (doto res
          (.onNext (-> (EqResponse/newBuilder)
                       (.setResult result)
                       (.build)))
          (.onCompleted))))))



(defn start-server
  [port]
  (let [server (-> (ServerBuilder/forPort port)
                   (.addService (calculator-service))
                   (.build)
                   (.start))]
    (-> (Runtime/getRuntime)
        (.addShutdownHook
         (Thread. (fn []
                    (if (not (nil? server))
                      (.shutdown server))))))
    (alter-var-root #'server (constantly server))
    server))

(defn stop-server
  []
  (.shutdown server))

(defn -main
  [& args]
  (let [port (or (first args) server-port)]
    (start-server port)))



