(ns todoapi.todo.todo
  (:require [korma.db :refer :all]
            [korma.core :refer :all]
            [todoapi.db :refer :all]))

(defentity todo)

(defn find-all []
  (select todo))

(defn find-by-id [id]
  (select todo
          (where {:id id})
          (limit 1)))

(defn create [name active]
  (insert todo
          (values {:name name :active active})))

(defn update-by-id [id name]
  (update todo
          (set-fields {:name name })
          (where {:id id})))

(defn delete-by-id [id]
  (delete todo
          (where {:id id})))
