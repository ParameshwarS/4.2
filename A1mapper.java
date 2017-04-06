import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*; 


public class A1mapper extends Mapper<LongWritable, Text,Text,IntWritable> {
	IntWritable i = new IntWritable(1);
	public void map(LongWritable key, Text value, Context context) 
			throws IOException, InterruptedException {
		String[] s=value.toString().split(Pattern.quote("|"));
		Text name=new Text(s[0]);
		if(!(s[0].equals("NA")||s[1].equals("NA")))
		{
		context.write(name,i);
		}
	}
}