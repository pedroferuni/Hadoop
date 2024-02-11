package GHadoop;


import java.io.IOException;
import java.util.regex.Pattern; 
import org.apache.hadoop.lo.IntWritable; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer; 

public class WordCounterReducer extends Reducer<Text, IntWritable,Text ,IntWritable> 
{ 
	 
	 
	public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException 
	{ 
	int sum=O; 
	for(IntWritable count:values)
	{ 
		sum += count.get();
	} 
	context.write(key,new IntWritable(sum));
}
	 
} 

