# AsyncTaskTutorial
AsyncTask

![Image alt](https://github.com/TishkevichLeonid/AsyncTaskTutorial/raw/master/5.jpg)

#### Код класса sub класса AsyncTask<>

```java

 public class ProgressTask extends AsyncTask<Void, Integer, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 0; i < integers.length; i++){
                publishProgress(i);
                SystemClock.sleep(500);
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            mIdicatorBar.setProgress(values[0] + 1);
            mStatusView.setText("Статус" + String.valueOf(values[0] + 1));
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(MainActivity.this, "Задача завершена", Toast.LENGTH_SHORT).show();
        }
    }

```
