(ns leiningen.new.myapp
  (:use [leiningen.new.templates :only [renderer name-to-path sanitize-ns ->files]]))

(def render (renderer "myapp"))

(defn myapp
  [name]
  (let [data {:name name
              :ns-name (sanitize-ns name)
              :sanitized (name-to-path name)}]
    (->files data ["test/{{sanitized}}/core_test.clj" (render "core_test.clj" data)]
["dev/user.clj" (render "user.clj" data)]
["project.clj" (render "project.clj" data)]
["dev/dev.clj" (render "dev.clj" data)]
["src/clj/{{sanitized}}/core.clj" (render "core.clj" data)]
["src/clj/{{sanitized}}/system.clj" (render "system.clj" data)]
[".gitignore" (render ".gitignore")]
["stop.sh" (render "stop.sh" data)]
["start.sh" (render "start.sh" data)]
)))
