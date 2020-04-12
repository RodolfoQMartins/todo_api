(ns todoapi.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [todoapi.todo.todo :as todo]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
           (GET "/todos" [] (todo/find-all))
           (POST "/todos" req
             (let [active (get-in req [:body :active])
                   name (get-in req [:body :name])]
                   (todo/create name active)))
           (route/not-found "Not Found"))


(def app
  (wrap-json-response (wrap-json-body app-routes {:keywords? true :bigdecimals? true} (assoc-in site-defaults [:security :anti-forgery] false)))
  )
