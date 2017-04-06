import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*;

public class A2reducer extends Reducer<Text, IntWritable, Text, IntWritable>
	{
		IntWritable i= new IntWritable();
		
		public void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException
		{
			int s = 0;
			for (IntWritable value : values) {
				s += value.get();
			}
			i.set(s);
			context.write(key,i);
		}
	
}