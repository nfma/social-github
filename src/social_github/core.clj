(ns social-github.core
  (require [compojure.core :as c]))

(def facebook
  (c/GET "/" {} "hello world!"))

(c/defroutes app facebook)

(c/defroutes dev-app facebook)

(defn -main [& args]
  (with-command-line args
    "Social Github"
    [[port "Port number where the app will start" 3000]
     [prod "run this app in reload mode" false]]
    (if prod
      (run-jetty (var app) {:port (Integer/valueOf port)})
      (run-jetty (var dev-app) {:port (Integer/valueOf port)}))))

