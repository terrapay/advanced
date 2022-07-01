no db


mvnw spring-boot:build-image
docker run -p 8080:8080 demo:0.0.1-SNAPSHOT
 localhost:8080/actuator/health

docker tag demo:0.0.1-SNAPSHOT pariwesh01/test1<tagName>
docker push pariwesh01/test1<tagName>
kubectl create deployment demo --image=pariwesh01/<tagName> --dry-run=client -o=yaml > deployment.yaml
 open file --- >> deployment.yaml
 kubectl create service clusterip service-demo --tcp=8080:8080 --dry-run=client -o=yaml >> deployment.yaml

 kubectl apply -f deployment.yaml
 kubectl get all

kubectl scale deployment <deployment_name> --replicas=2
kubectl autoscale deployment <deployment_name> --cpu-percent=50 --min=1 --max=10
