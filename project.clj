(defproject clj-grpc-demo "0.1.0-SNAPSHOT"
  :description "Example to demonstate usage of GRPC with Clojure"
  :url "https://github.com/shalapatil/clj-grpc-demo.git"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main ^:skip-aot clj-grpc-demo.server
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}

  :plugins [[lein-protoc "0.5.0"]]
  :protoc-version "3.6.0"
  :protoc-grpc {:version "1.13.1"}
  :proto-target-path "target/generated-sources/protobuf"
  :java-source-paths ["target/generated-sources/protobuf"]

  :dependencies
  [[org.clojure/clojure "1.8.0"]
   [com.google.protobuf/protobuf-java "3.6.0"]
   [javax.annotation/javax.annotation-api "1.2"]
   [io.netty/netty-codec-http2 "4.1.25.Final"]
   [io.grpc/grpc-core "1.13.1"]
   [io.grpc/grpc-netty "1.13.1"
    :exclusions [io.grpc/grpc-core
                 io.netty/netty-codec-http2]]
   [io.grpc/grpc-protobuf "1.13.1"]
   [io.grpc/grpc-stub "1.13.1"]])
