package com.example.wechat.ui.chats;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wechat.ChatEntity;
import com.example.wechat.ChattingActivity;
import com.example.wechat.databinding.FragmentChatsBinding;
import com.example.wechat.myAdapter;

import java.util.ArrayList;

public class ChatsFragment extends Fragment {

    private FragmentChatsBinding binding;
    public RecyclerView mCollectRecyclerView;
    private ArrayList<ChatEntity>chatEntities = new ArrayList<ChatEntity>();
    private myAdapter mCollectRecyclerAdapter;
    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ChatsViewModel chatsViewModel =
                new ViewModelProvider(this).get(ChatsViewModel.class);

        binding = FragmentChatsBinding.inflate(inflater, container, false);

        root = binding.getRoot();
        initRecyclerView();
        initData();
        return root;
    }

    private void initData() {
        for (int i=0;i<10;i++){
            ChatEntity chatEntity=new ChatEntity();
            chatEntity.setChatName("聊天者"+i);
            chatEntity.setChatRecord("Message"+i);
            chatEntities.add(chatEntity);
        }
    }

    private void initRecyclerView() {
        mCollectRecyclerView=binding.chatRecyclerView;
        mCollectRecyclerAdapter = new myAdapter(getActivity(), chatEntities);
        //给RecyclerView设置adapter
        mCollectRecyclerView.setAdapter(mCollectRecyclerAdapter);
        //设置layoutManager,可以设置显示效果，是线性布局、grid布局，还是瀑布流布局
        //参数是：上下文、列表方向（横向还是纵向）、是否倒叙
        mCollectRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        //设置item的分割线
        mCollectRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        //RecyclerView中没有item的监听事件，需要自己在适配器中写一个监听事件的接口。参数根据自定义
        mCollectRecyclerAdapter.setOnItemClickListener(new myAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, ChatEntity data) {
                //此处进行监听事件的业务处理
                Toast.makeText(getActivity(),"你点击了我的消息",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent();
                String title = data.getChatName();
                intent.putExtra("title",title);
                intent.setClass(getActivity(), ChattingActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
