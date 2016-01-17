export TERM="xterm-256color"
tmux new-session -d -s {{ns-name}}
tmux split-window -t {{ns-name}}:1 -v
tmux rename-window main
tmux send-keys -t {{ns-name}}:1.1 "vim src/clj/{{sanitized}}/core.clj" "Enter"
tmux send-keys -t {{ns-name}}:1.2 "lein repl" "Enter"
tmux new-window -t {{ns-name}}:2
tmux select-window -t {{ns-name}}:2
tmux rename-window shell
tmux select-window -t {{ns-name}}:1
tmux attach -t {{ns-name}}

