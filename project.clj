(defproject social-github "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.3.0"]
		 [compojure "0.6.5" :exclusions [org.clojure/clojure org.clojure/clojure-contrib]]
		 [ring/ring-servlet "0.3.11"]
		 [clj-http "0.2.1"]]
  :dev-dependencies [[lein-ring "0.4.5"]
		     [ring/ring-jetty-adapter "0.3.11" :exclusions [javax.servlet/servlet-api ring/ring-core ring/ring-servlet org.clojure/clojure org.clojure/clojure-contrib]]
                     [ring/ring-devel "0.3.11" :exclusions [javax.servlet/servlet-api ring/ring-core ring/ring-servlet org.clojure/clojure org.clojure/clojure-contrib clj-stacktrace]]
                     [ring-reload-modified "0.1.1" :exclusions [javax.servlet/servlet-api ring/ring-core ring/ring-servlet org.clojure/clojure org.clojure/clojure-contrib]]]
  :ring {:handler social-github.core/app}
  :jvm-opts ["-Xmx500m"]
  :main social-github.core)
