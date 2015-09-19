(defproject website "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [
                 ;[org.dunaj/dunaj "0.7.0"]
                 [org.clojure/clojure "1.7.0"]
                 [hiccup "1.0.5" :exclusions [org.clojure/clojure]]
                 [compojure "1.4.0"]
                 [ring/ring-defaults "0.1.5"]
                 [slamhound "1.5.5"]]
  :plugins [[lein-ring "0.8.13"]
            [jonase/eastwood "0.2.1"]
            [lein-kibit "0.1.2"]
            [lein-ancient "0.6.7"]
            [venantius/ultra "0.3.4"]]
  :ultra {:color-scheme :solarized_dark}
  :ring {:handler website.handler/app}
  :aliases {"slamhound" ["run" "-m" "slam.hound"]
            "omni"        ["ancient" "slamhound" "kibit"
                        "eastwood"]}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
