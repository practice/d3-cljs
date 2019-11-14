(ns d3-cljs.test.handler
  (:require
    [clojure.test :refer :all]
    [ring.mock.request :refer :all]
    [d3-cljs.handler :refer :all]
    [d3-cljs.middleware.formats :as formats]
    [muuntaja.core :as m]
    [mount.core :as mount]))

(defn parse-json [body]
  (m/decode formats/instance "application/json" body))

(use-fixtures
  :once
  (fn [f]
    (mount/start #'d3-cljs.config/env
                 #'d3-cljs.handler/app-routes)
    (f)))

(deftest test-app
  (testing "main route"
    (let [response ((app) (request :get "/"))]
      (is (= 200 (:status response)))))

  (testing "not-found route"
    (let [response ((app) (request :get "/invalid"))]
      (is (= 404 (:status response))))))
