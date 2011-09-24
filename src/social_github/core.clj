(ns social-github.core
  (:require [clojure.contrib.command-line :as cccl]
	    [ring.adapter.jetty :as raj]
	    [compojure.core :as c]))

(def facebook
  (c/GET "/" {} "hello world!"))

(def facebook-post
  (c/POST "/" {} "hello world!"))

(c/defroutes app facebook facebook-post)

(c/defroutes dev-app facebook facebook-post)

(defn -main [& args]
  (cccl/with-command-line args
    "Social Github"
    [[port "Port number where the app will start" 3000]
     [prod "run this app in reload mode" false]]
    (if prod
      (raj/run-jetty (var app) {:port (Integer/valueOf port)})
      (raj/run-jetty (var dev-app) {:port (Integer/valueOf port)}))))

