
cd $2

unzip -o $2"/$1.zip" "*"

printf "unzipping -> $2""/$1.zip\n"
printf "unzipped -> $2""/$1.zip\n"

rm -v $2"/$1.zip"


bash $2/gradlew setupDecompWorkspace

printf "Set up workspace"

bash $2/gradlew eclipse

printf "Set up eclipse"

exit

