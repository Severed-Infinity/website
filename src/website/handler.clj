(ns website.handler
  ;(:api dunaj)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [hiccup.core :as hic]))

(def nav
  (hic/html
    [:nav
     [:a {:href "/"} "Home"]
     " | "
     [:a {:href "/edu"} "Education"]
     " | "
     [:a {:href "/reviews"} "Reviews/Comments"]
     " | "
     [:a {:href "/"} "CV"]]))

(defn about-page []
  (hic/html nav
    [:section {}
     [:h1 {} "About Me"]
     [:p {} "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ornare sagittis magna et bibendum. Nullam luctus vitae massa at elementum. Suspendisse ipsum nisi, tempus sit amet arcu et, semper scelerisque neque. Morbi posuere luctus eros eu convallis. Vivamus auctor massa mi, sit amet mollis felis maximus ac. In maximus ex leo, at dictum augue lobortis sed. Etiam sit amet velit lacus. Maecenas leo nisl, vulputate quis bibendum in, iaculis a velit. Donec feugiat cursus libero hendrerit dapibus. Donec imperdiet lectus sem, vel dapibus odio ultricies vel. In condimentum urna enim, vitae viverra metus facilisis vel. Vestibulum justo ante, accumsan ut nulla vehicula, sodales elementum nulla. Nulla in velit non lorem tempus imperdiet id in sem. Integer sit amet dui odio. Praesent hendrerit blandit vulputate."]
     [:p {} "Nunc consectetur efficitur imperdiet. Integer felis lacus, facilisis sed varius facilisis, lobortis non enim. Donec accumsan est id dictum volutpat. Sed vel magna ultricies, maximus nisi vitae, consectetur enim. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla vel mattis enim, non mollis tellus. Suspendisse vitae ultrices nulla, et lobortis nunc. Etiam sit amet lacus ac purus gravida pellentesque vitae id risus. Sed ornare est ut lectus dictum blandit. Pellentesque sed nisi enim. Nam in dapibus dui. Aenean ullamcorper varius neque, eu hendrerit nulla faucibus eu. Quisque ac tellus accumsan, tempus ligula ac, sodales quam. Phasellus eget erat sed nunc gravida mollis a eget mi. Suspendisse maximus lacinia fermentum. Morbi sit amet consectetur nibh, id sodales magna."
      ]]
    [:img {:src "" :alt "profile image of me"}]))

(defn edu-page []
  nav)

(defn review-page []
  nav)

(defroutes app-routes
  (GET "/" [] (about-page))
  (GET "/edu" [] (edu-page))
  (GET "/reviews" [] (review-page))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
