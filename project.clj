(defproject clojure-advent "0.1.0-SNAPSHOT"
  :description "clojure advent "
  :url "https://github.com/germ13/clojure-advent"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot clojure-advent.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev {:plugins [[cider/cider-nrepl "0.16.0"]]}})
