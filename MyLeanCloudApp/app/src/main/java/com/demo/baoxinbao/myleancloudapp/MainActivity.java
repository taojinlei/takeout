package com.demo.baoxinbao.myleancloudapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.*;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ListView调用setAdapter()并套用创建好的UserAdapter
        ListView lvUser = (ListView) findViewById(R.id.lvUser);
        lvUser.setAdapter(new UserAdapter(this));

        //ListView注册Click监听 即每个选项被点击后发生什么,此处仅为Toast输出,晚点改成Activity跳转
        lvUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user = (User) parent.getItemAtPosition(position);
                String text = "userId = " + user.getUserId() + "\nuserName = " +
                        user.getUserName() + "\nuserPassWord = " + user.getPassWord();
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });


//        // 测试 SDK 是否正常工作的代码
//        final AVObject testObject = new AVObject("TestObject");
//        testObject.put("words", "Hello World!");
//        testObject.put("name","baoxinbao");
//
//        AVObject todoFolder = new AVObject("TodoFolder");// 构建对象
//        todoFolder.put("name", "工作");// 设置名称
//        todoFolder.put("priority", 1);// 设置优先级
//        todoFolder.saveInBackground();
//        testObject.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(AVException e) {
//                if (e == null) {
//                    Log.d("saved", "success!");
//                    Toast.makeText(MainActivity.this,"success,objectId:"+testObject.getObjectId()+"\n" +
//                            "getCreateAt:"+testObject.getCreatedAt(),Toast.LENGTH_SHORT).show();
//                }
//            }
//        });


//        //leanCloud注册新用户
//        AVUser user = new AVUser();// 新建 AVUser 对象实例
//        user.setUsername("bxb");// 设置用户名
//        user.setPassword("123456");// 设置密码
//        user.setEmail("278578301@qq.com");// 设置邮箱
//        user.signUpInBackground(new SignUpCallback() {
//            @Override
//            public void done(AVException e) {
//                if (e == null) {
//                    // 注册成功
//                } else {
//                    // 失败的原因可能有多种，常见的是用户名已经存在。
//                }
//            }
//        });

    }

    //找到控件
    public void findViews() {
    }

    //实现用户的注册
    public void register() {
    }

    //创建UserAdapter 注册OnItemClickListener
    private class UserAdapter extends BaseAdapter {
        private LayoutInflater layoutInflater;
        private List<User> userList;
        //创建User类

        public UserAdapter(Context context) {
            //获取LayoutInflater对象以便动态加载layout文件
            layoutInflater = LayoutInflater.from(context);

            //====================userList是数据源,晚点这个从leanCloud里加载出来,现在暂时手动添加
            userList = new ArrayList<>();
            userList.add(new User("testName1", "123456"));
            userList.add(new User("testName2", "123456"));



        }

        @Override
        public int getCount() {
            return userList.size();
        }

        @Override
        public Object getItem(int position) {
            return userList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return userList.get(position).getUserId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //返回的是converView 当converView为空时,inflate载入
            if (convertView == null)
                convertView = layoutInflater.inflate(R.layout.listview_item, parent, false);
            User user = userList.get(position);
            TextView tvId = (TextView) convertView.findViewById(R.id.tvId);
            TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
            TextView tvPassWord = (TextView) convertView.findViewById(R.id.tvPassWord);

            tvId.setText(String.valueOf(user.getUserId()));
            tvName.setText(user.getUserName());
            tvPassWord.setText(user.getPassWord());
            return convertView;
        }
    }
}
