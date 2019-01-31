(ns clj-grpc-demo.client)


(def server-port 55555)


(defn- get-channel
  []
  (-> (io.grpc.ManagedChannelBuilder/forAddress "localhost" server-port)
      (.usePlaintext true)
      (.build)))


(def client
  (io.grpc.calculator.CalculatorGrpc/newBlockingStub (get-channel)))


(defn add
  [v1 v2]
  (-> (.add client
            (-> (io.grpc.calculator.EqRequest/newBuilder)
                (.setVar1 v1)
                (.setVar2 v2)
                .build))
      .getResult))


(defn subtract
  [v1 v2]
  (-> (.subtract client
                 (-> (io.grpc.calculator.EqRequest/newBuilder)
                     (.setVar1 v1)
                     (.setVar2 v2)
                     .build))
      .getResult))
