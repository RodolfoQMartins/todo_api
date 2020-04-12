(ns todoapi.db
  (:use korma.db))

(defdb db (mysql
            { :classname "com.mysql.jdbc.Driver"
             :subprotocol "mysql"
             :subname "//localhost:3306/TODO"
             :user "root"
             :password ""}))