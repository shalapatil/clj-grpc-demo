(defproject clj-grpc-demo "0.1.0-SNAPSHOT"
  :description "Example to demonstate usage of GRPC with Clojure"
  :url "https://github.com/shalapatil/clj-grpc-demo.git"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot clj-grpc-demo.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
