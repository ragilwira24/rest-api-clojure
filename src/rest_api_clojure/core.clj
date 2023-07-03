(ns rest-api-clojure.core
  (:require [compojure.core :refer :all]
            [rest-api-clojure.handler.request-handler :as request-handler]
            [ring.middleware.defaults :refer :all]
            [org.httpkit.server :as server])
  (:gen-class))

(defroutes app-routes
  (GET "/name/:name" [name] (request-handler/name-handler name)))

(defn -main
  "Main Program"
  [& args]
  (let [port (Integer/parseInt (or (System/getenv "PORT") "8080"))]
    (server/run-server #'app-routes {:port port})
    (println (str "Running the server at http://localhost:" port "/"))))