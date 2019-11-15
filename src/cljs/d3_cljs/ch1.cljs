(ns d3-cljs.ch1
  (:require [reagent.core :as reagent]
            [cljsjs.d3 :as d3]
            [re-frame.core :as rf]))

(defn update-div []
  (let [data #js ["filler" "filler" "filler" "filler" "xxxx"]]
    (-> js/d3 (.select "body") (.selectAll "div.mydiv")
        (.selectAll "*") (.remove)
        (.data data) .enter
        (.append "div")
        (.html "Wow")
        (.append "span")
        (.html "Event more Wow")
        (.style "font-weight", "900")))
  )
(defn d3-app [data & {:keys [map-id radius zoom height show-control show-pm25 show-pm-ratio]
               :or {map-id "map" radius 9 zoom 5 height "800px" show-control true show-pm25 true show-pm-ratio true}}]
  (let []
    (reagent/create-class                 ;; <-- expects a map of functions
      {:display-name
       "D3-app"      ;; for more helpful warnings & errors

       :component-did-mount               ;; the name of a lifecycle function
       (fn [component]
         (js/console.log "component-did-mounted")
         (update-div)
         )

       :component-did-update              ;; the name of a lifecycle function
       (fn [component old-argv]                ;; reagent provides you the entire "argv", not just the "props"
         (let [new-argv (rest (reagent/argv component))]
           (js/console.log "component did update:" (first new-argv))
           (update-div)
           ))

       :reagent-render        ;; Note:  is not :render
       (fn [data]           ;; remember to repeat parameters
         (js/console.log "Rendering map dom with" data)
         [:div.col-md-12
          [:p "Chapter 1"]
          [:div.mydiv]])}))
  )

(defn main []
  (let [
        ]
    [:section.section>div.container>div.content
     [:div.col-md-10
      [:div.row
       [d3-app "hello"]]
      ]
     ]
    ))


