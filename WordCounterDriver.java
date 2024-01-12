package hadoop;
import org.apache.hadoop.conf.Configured; 
import org.apache.hadoop.fs.Path; 
import org.apache.hadoop.io.IntWrltable; 
import org.apache.hadoop.io.Text; 
import org.apache.hadoop.mapreduce.Job; 
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat; 
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat; 
import org.apache.hadoop.util.Tool; 
import org.apache.hadoop.utll.ToolRunner;

public class WordCounterDriver extends Configured implements Tool { 
	
	public static void main(String[] args) throws Exception { 
		int res ToolRunner.run(new WordCounterDriver(), args); 
		System.exit(res); 
	}
	 
	public int run(String[] args) throws Exception { 
		Job Job= Job.getInstance(getConf(),"WordCounter"); 
		job.setJarByClass(this.getClass());
		FileInputFormat.addInputPath(job, new Path(args[0])); 
		FIleOutputFormat.setOutputPath(job, new Path(args[1])); 
			job.setMapperClass(WordCounterMapper.class); 
			job.SetReducerClass(WordCounterReducer.class); 
			job.setOutputkeyClass(Text.class); 
			job.setOutputValueClass(IntWritable.class); 
			return job.waitForComplet1on(true) ? 0:1; 
	}
	

}
