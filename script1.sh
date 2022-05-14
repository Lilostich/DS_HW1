#hdfs dfs -mkdir /user
#hdfs dfs -mkdir /user/root
hdfs dfs -rm -r input
hdfs dfs -rm -r output
python logCreator.py
mkdir input
cp /var/log/messages input/syslog_"$(date +'%Y_%m_%d_%H%M%S')"
hdfs dfs -put input input
yarn jar target/lab1-1.0-SNAPSHOT-jar-with-dependencies.jar input output
#-for check result from snappy+seqfile
#hdfs dfs -text output/part-r-00001
