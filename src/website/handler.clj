(ns website.handler
  ;(:api dunaj)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [hiccup
             [core :as hic]
             [util :refer [to-uri]]]))

(def nav
  (hic/html
    [:nav
     [:a {:href "/"} "Home"]
     " | "
     [:a {:href "/proj"} "Projects"]
     " | "
     [:a {:href "/edu"} "Education"]
     " | "
     [:a {:href "/reviews"} "Reviews/Comments"]
     " | "
     [:button {:type "button"} "CV"]]))

(defn page [& more]
  (hic/html
    nav
    more))

(def tag-line
  (hic/html
    [:aside
     [:h1 "The up-and-comer"]

     ;;TODO only temporary list
     #_[:ol
      [:li "What am I?"]
      [:li "What do I do?"]
      [:li "Where am I from? (county/city)"]
      [:li "Freelancer, working, looking for work?"]]

     [:p "Highly intuitive, adept at programming with
     experience in web development based in Dublin; "
      [:br]
      "Seeking to expand and develop new skills while
      looking for challenging and unique opportunities."]

     #_[:p "A programmer and web designer plucked right
     from the hands of god." [:br]
        "who loves to build websites and challenge my
        coding skills." [:br]
        "living in dublin"
        [:br]
        "looking to develop something different and
        unique"]]))

(def about-page
  (page
    (hic/html
      tag-line
      [:section
       [:h1 "About Me"]
       [:p "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ornare sagittis magna et bibendum. Nullam luctus vitae massa at elementum. Suspendisse ipsum nisi, tempus sit amet arcu et, semper scelerisque neque. Morbi posuere luctus eros eu convallis. Vivamus auctor massa mi, sit amet mollis felis maximus ac. In maximus ex leo, at dictum augue lobortis sed. Etiam sit amet velit lacus. Maecenas leo nisl, vulputate quis bibendum in, iaculis a velit. Donec feugiat cursus libero hendrerit dapibus. Donec imperdiet lectus sem, vel dapibus odio ultricies vel. In condimentum urna enim, vitae viverra metus facilisis vel. Vestibulum justo ante, accumsan ut nulla vehicula, sodales elementum nulla. Nulla in velit non lorem tempus imperdiet id in sem. Integer sit amet dui odio. Praesent hendrerit blandit vulputate."]
       [:p "Nunc consectetur efficitur imperdiet. Integer felis lacus, facilisis sed varius facilisis, lobortis non enim. Donec accumsan est id dictum volutpat. Sed vel magna ultricies, maximus nisi vitae, consectetur enim. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla vel mattis enim, non mollis tellus. Suspendisse vitae ultrices nulla, et lobortis nunc. Etiam sit amet lacus ac purus gravida pellentesque vitae id risus. Sed ornare est ut lectus dictum blandit. Pellentesque sed nisi enim. Nam in dapibus dui. Aenean ullamcorper varius neque, eu hendrerit nulla faucibus eu. Quisque ac tellus accumsan, tempus ligula ac, sodales quam. Phasellus eget erat sed nunc gravida mollis a eget mi. Suspendisse maximus lacinia fermentum. Morbi sit amet consectetur nibh, id sodales magna."
        ]]
      [:img {:alt "profile image of me"
             :src 'images/IMG_2247.jpg}])))
;;TODO must update image to one of myself
;(to-uri "images/IMG_2247.jpg")

(def edu
  (hic/html
    [:section
     [:h1 "Education and Results"]
     [:ul
      [:li "IT-Tallaght"
       [:ol
        [:li "Fourth Year"]
        [:li "Third Year"]
        [:li "Second Year"]
        [:li "First Year"]]]
      [:li "Pearse College of further education"
       [:ol
        [:li "Fetac Level 6"]
        [:li "Fetac Level 5"]
        [:li "Repear Leaving Cert"]]]
      [:li "St. Marks Community School"]]]
    [:aside
     [:h1 "Merits and Awards"]
     [:ul
      [:li "Zero Days missed"]
      [:li "Trinity Access Program (TAP)"]]]))

(defn edu-page []
  (page edu))

(defn review-page []
  (page))

(defn proj-page []
  (page
    [:a {:href "https://github.com/Severed-Infinity"}
     "Severed-Infinity - Github account"]))

(defroutes app-routes
  (GET "/" [] about-page)
  (GET "/edu" [] (edu-page))
  (GET "/reviews" [] (review-page))
  (GET "/proj" [] (proj-page))
  (route/resources "/resources/public/")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
