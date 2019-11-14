(ns d3-cljs.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [d3-cljs.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[d3-cljs started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[d3-cljs has shut down successfully]=-"))
   :middleware wrap-dev})
