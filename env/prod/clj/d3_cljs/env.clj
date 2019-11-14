(ns d3-cljs.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[d3-cljs started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[d3-cljs has shut down successfully]=-"))
   :middleware identity})
