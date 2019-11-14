(ns d3-cljs.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [d3-cljs.core-test]))

(doo-tests 'd3-cljs.core-test)

