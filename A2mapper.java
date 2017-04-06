import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*; 


public class A2mapper extends Mapper<LongWritable, Text,Text,IntWritable> {
	IntWritable i = new IntWritable(1);
	public void map(LongWritable key, Text value, Context context) 
			throws IOException, InterruptedException {
		String[] s=value.toString().split(Pattern.quote("|"));
		Text state=new Text(s[3]);
		if(!(s[0].equals("NA")||s[1].equals("NA")))
		{
			if(s[0].equals("Onida"))
		context.write(state,i);
		}
	}
}