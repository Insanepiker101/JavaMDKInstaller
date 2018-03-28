
cp $HOME/.JavaMDKInstaller/Config/versions/$1.zip $2 -v
bash $HOME/.JavaMDKInstaller/Config/handlers/UnzipHandler.sh $1 $2 -v

printf $1">" >> $HOME"/.JavaMDKInstaller/Config/name.cfg"
printf $2"/eclipse/>" >> $HOME"/.JavaMDKInstaller/Config/path.cfg"
exit
