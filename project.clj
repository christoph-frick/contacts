(defproject contacts "0.3.0"
  :description "Contact list technical study for Om next"
  :url "https://github.com/tmarble/contacts"
  :license {:name "MIT"
            :url "http://opensource.org/licenses/MIT"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "0.0-3308"]
                 ;; [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 ;; [cljs-http "0.1.35"]
                 [org.omcljs/om "0.9.0"]]

  :plugins [[lein-cljsbuild "1.0.6"]
            [lein-figwheel "0.3.1"
             :exclusions [org.clojure/clojure]]]

  :hooks [leiningen.cljsbuild]

  :figwheel {:css-dirs ["resources/public/css"]}

  :source-paths ["src/clj"] ;; NOTE: not used

  ;; clean generated JavaScript
  :clean-targets ^{:protect false}
  ["resources/public/js/compiled" :target-path :compile-path]

  :profiles
  {:dev {:cljsbuild
         {:builds
          {:app
           {:source-paths ["src/cljs"]
            :figwheel {:websocket-host "localhost"}
            :compiler {:main contacts.demo3
                       :output-dir "resources/public/js/compiled"
                       :output-to  "resources/public/js/compiled/app.js"
                       :asset-path "js/compiled"
                       :source-map true
                       :source-map-timestamp true
                       :verbose true
                       :cache-analysis true
                       :optimizations :none
                       :pretty-print false}}}}}})
