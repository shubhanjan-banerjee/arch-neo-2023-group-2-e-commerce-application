# For pkg in docker.io docker-doc docker-compose podman-docker containerd runc; do sudo apt-get remove $pkg; done

sudo apt-get update
sudo apt-get install ca-certificates curl gnupg
sudo install -m 0755 -d /etc/apt/keyrings
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg
sudo chmod a+r /etc/apt/keyrings/docker.gpg

# gh installation in linux

type -p curl >/dev/null || (sudo apt update && sudo apt install curl -y)
curl -fsSL https://cli.github.com/packages/githubcli-archive-keyring.gpg | sudo dd of=/usr/share/keyrings/githubcli-archive-keyring.gpg \
&& sudo chmod go+r /usr/share/keyrings/githubcli-archive-keyring.gpg \
&& echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/githubcli-archive-keyring.gpg] https://cli.github.com/packages stable main" | sudo tee /etc/apt/sources.list.d/github-cli.list > /dev/null \
&& sudo apt update \
&& sudo apt install gh -y


git config --global user.name "shubhanjan-banerjee"
git config --global user.email "shubhanjan.banerjee@cognizant.com"
ssh-keygen -t rsa -b 4096 -C "shubhanjan.banerjee@cognizant.com"
ssh git@github.com


echo \
 "deb [arch="$(dpkg --print-architecture)" signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/ubuntu \
 "$(. /etc/os-release && echo "$VERSION_CODENAME")" stable" | \
 sudo tee /etc/apt/sources.list.d/docker.list > /dev/null

sudo apt-get update
sudo apt-get install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin

docker login

# Install FluxCD in Linux
curl -s https://fluxcd.io/install.sh | sudo bash

mkcert -key-file key.pem -cert-file cert.pem dev.cognizant.com \*.cognizant.com
mkcert -install

LINUX:
export GITHUB_TOKEN=ghp_*****************************
export GITHUB_USER=shubhanjan-banerjee

WINDOWS:
set GITHUB_TOKEN ghp_*****************************
set GITHUB_USER shubhanjan-banerjee

sudo service docker start
sudo minikube start --force

echo $GITHUB_USER

flux check --pre

flux bootstrap github --owner=$GITHUB_USER --repository=arch-neo-2023-group-2-e-commerce-application-env --branch=main --read-write-key --personal --path=./clusters/my-cluster --token-auth=true

git clone git@github.com:shubhanjan-banerjee/arch-neo-2023-group-2-e-commerce-application-env.git

cd arch-neo-2023-group-2-e-commerce-application-env

flux create source git ecommerce-app --url=https://github.com/shubhanjan-banerjee/arch-neo-2023-group-2-e-commerce-application --branch=main --interval=1m --export > ./clusters/my-cluster/ecommerce-app-source.yaml

flux create kustomization ecommerce-app --target-namespace=default --source=ecommerce-app --path="./clusters/kustomize/" --prune=true --wait=true --interval=30m --retry-interval=2m --health-check-timeout=3m --export > ./clusters/my-cluster/ecommerce-app-kustomization.yaml

git add -A && git commit -m "Add podinfo Kustomization"
git push

flux reconcile kustomization ecommerce-app --with-source

flux get kustomizations --watch

sudo minikube stop
sudo service docker stop
