
cp $HOME/.JavaMDKInstaller/Config/versions/$1.zip $2 -v
bash $HOME/.JavaMDKInstaller/Config/handlers/UnzipHandler.sh $1 $2 -v
##rm $2"/$1.zip" -v
exit
