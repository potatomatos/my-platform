package cn.cxnxs.test;

import com.alibaba.fastjson.JSONObject;

import javax.script.ScriptException;

public class Demo {
    public static void main(String[] args) throws ScriptException {
        String str = "{\\\"link\\\":\\\"https:\\/\\/www.cnblogs.com\\/mokou\\/p\\/9378543.html\\\",\\\"description\\\":\\\"\\u867D\\u7136\\u8BF4\\u539F\\u7406\\u5F88\\u597D\\u7406\\u89E3\\uFF0C\\u4F46\\u662F\\u4EE3\\u7801\\u7406\\u89E3\\u4E86\\u82B1\\u8D39\\u6211\\u4E00\\u4E2A\\u4E0B\\u5348\\u7684\\u65F6\\u95F4\\uFF0C\\u8111\\u9614\\u75DB \\u8BE5\\u6CE8\\u91CA\\u7684\\u5730\\u65B9\\u90FD\\u6807\\u8BB0\\u4E86\\uFF0C\\u5E0C\\u671B\\u4EE5\\u540E\\u770B\\u5230\\u8FD9\\u4E9B\\u4EE3\\u7801\\u6211\\u8FD8\\u80FD\\u597D\\u597D\\u7406\\u89E3\\u5427 \\u5B66\\u4E60\\u7684\\u94FE\\u63A5\\u5730\\u5740\\uFF1Ahttps:\\/\\/www.cnblogs.com\\/teble\\/p\\/7280575.html\\\",\\\"title\\\":\\\"\\u30102018.07.27\\u3011\\uFF08\\u5B57\\u7B26\\u4E32\\/\\u627E\\u76F8\\u540C\\uFF09\\u5B66\\u4E60KMP\\u7B97\\u6CD5\\u5C0F\\u8BB0\\\",\\\"pubDate\\\":\\\"2018-07-27 16:55\\\",\\\"content\\\":\\\"\\u867D\\u7136\\u8BF4\\u539F\\u7406\\u5F88\\u597D\\u7406\\u89E3\\uFF0C\\u4F46\\u662F\\u4EE3\\u7801\\u7406\\u89E3\\u4E86\\u82B1\\u8D39\\u6211\\u4E00\\u4E2A\\u4E0B\\u5348\\u7684\\u65F6\\u95F4\\uFF0C\\u8111\\u9614\\u75DB \\u8BE5\\u6CE8\\u91CA\\u7684\\u5730\\u65B9\\u90FD\\u6807\\u8BB0\\u4E86\\uFF0C\\u5E0C\\u671B\\u4EE5\\u540E\\u770B\\u5230\\u8FD9\\u4E9B\\u4EE3\\u7801\\u6211\\u8FD8\\u80FD\\u597D\\u597D\\u7406\\u89E3\\u5427 \\u5B66\\u4E60\\u7684\\u94FE\\u63A5\\u5730\\u5740\\uFF1Ahttps:\\/\\/www.cnblogs.com\\/teble\\/p\\/7280575.html \\/*     Number Sequence     *\\/\\n\\/*Given two sequences of numbers : a[1], a[2], ...... , a[N], and b[1], b[2], ...... , b[M] (1 <= M <= 10000, 1 <= N <= 1000000). Your task is to find a number K which make a[K] = b[1], a[K + 1] = b[2], ...... , a[K + M - 1] = b[M]. If there are more than one K exist, output the smallest one. \\nInput\\nThe first line of input is a number T which indicate the number of cases. Each case contains three lines. The first line is two numbers N and M (1 <= M <= 10000, 1 <= N <= 1000000). The second line contains N integers which indicate a[1], a[2], ...... , a[N]. The third line contains M integers which indicate b[1], b[2], ...... , b[M]. All integers are in the range of [-1000000, 1000000]. \\nOutput\\nFor each test case, you should output one line which only contain K described above. If no such K exists, output -1 instead. \\nSample Input\\n2\\n13 5\\n1 2 1 2 3 1 2 3 1 3 2 1 2\\n1 2 3 1 3\\n13 5\\n1 2 1 2 3 1 2 3 1 3 2 1 2\\n1 2 3 2 1\\nSample Output\\n6\\n-1*\\/\\n#include <algorithm>\\n#include <iostream>\\n#include <cstring>\\n#include <cstdio>\\n#include <cmath>\\n#define MAXN 1000050\\nusing namespace std;\\n\\/\\/\\u8FD9\\u9053\\u9898\\u770B\\u5F97\\u51FA\\u6765\\u9700\\u8981\\u4F7F\\u7528\\u5230KMP\\u6392\\u5E8F\\n\\/\\/\\u867D\\u7136\\u8BF4\\u6211\\u7406\\u89E3\\u4E86\\u6392\\u5E8F\\u539F\\u7406\\uFF0C\\u5374\\u4E0D\\u592A\\u61C2\\u5F97\\u5B9E\\u73B0\\u5B83 \\n\\/\\/\\u5BF9\\u4E8E\\u6211\\u8FD9\\u79CD\\u6765\\u8BF4\\uFF0C\\u6700\\u62C5\\u5FC3\\u7684\\u7684\\u83AB\\u8FC7\\u4E8E\\u8F93\\u5165\\u95EE\\u9898\\uFF08\\u6240\\u4EE5\\u6700\\u540E\\u5E72\\u8106\\u7528int\\u6570\\u7EC4\\u89E3\\u51B3\\uFF09 \\nint a[MAXN], b[10050], _next[10050];\\nint repeat, i, n;\\n__int64 m;\\n\\nvoid makeNext()\\n{\\n    int q=1;\\/\\/\\u6A21\\u677Fb\\u5B57\\u7B26\\u4E32\\u7684\\u4E34\\u65F6\\u4E0B\\u6807\\uFF0C\\u4F5C\\u4E3A\\u6BD4\\u8F83\\u7684\\u540E\\u4E00\\u4F4D \\n    int k=0;\\/\\/\\u6700\\u5927\\u524D\\u540E\\u7F00\\u957F\\u5EA6\\n    _next[1]=0;\\/\\/\\u6A21\\u677F\\u5B57\\u7B26\\u4E32\\u7B2C\\u4E00\\u4E2A\\u5B57\\u7B26\\u6700\\u5927\\u524D\\u540E\\u7F00\\u957F\\u5EA6\\u4E3A0 \\n    while ( q<n )\\/\\/\\u904D\\u5386\\u6570\\u7EC4 \\n    {\\n        if ( k==0 || b[k]==b[q] )\\/\\/\\u7B26\\u5408\\u6761\\u4EF6 \\n        {\\n            ++k,++q;\\/\\/\\u540C\\u65F6+1\\uFF0C\\u5224\\u65AD\\u4E0B\\u4E00\\u4F4D \\n            if ( b[q]!=b[k] ) _next[q]=k;\\n                else _next[q]=_next[k];\\/\\/\\u4E0A\\u4E0B\\u4E24\\u53E5\\u8BDD\\u6539\\u53D8next\\u6570\\u7EC4\\u7684\\u503C \\n        } else k=_next[k];\\/\\/\\u5982\\u679C\\u4E0D\\u76F8\\u7B49\\uFF0C\\u5C06\\u524D\\u6807\\u5F80\\u524D\\u79FB\\u52A8 \\n    } \\n    \\/*\\u6570\\u636E\\u68C0\\u67E5for ( k=1 ; k<=n ; k++ )\\n    {\\n        cout<<b[k]<<' ';\\n    }\\n    cout<<endl;\\n    for ( k=1 ; k<=n ; k++ )\\n    {\\n        cout<<_next[k]<<' ';\\n    }\\n    cout<<endl;*\\/\\n}\\n\\nint kmp()\\n{\\n    int i, j;\\n    for ( i=1,j=1 ; i<=m&&j<=n ; )\\n    {\\n        if ( j==0 || a[i]==b[j] ) ++i,++j;\\n            else j=_next[j];\\/\\/\\u5982\\u679C\\u4E0D\\u76F8\\u7B49\\u7684\\u8BDD\\uFF0C\\u5C06\\u6B64\\u65F6\\u7684j\\u53D8\\u5C0F\\uFF0C\\u76F8\\u5F53\\u4E8E\\u5C06b\\u6570\\u7EC4\\u5F80\\u53F3\\u79FB\\u52A8 \\n            \\/\\/next\\u6570\\u7EC4\\u63D0\\u4F9B\\uFF0C\\u5F53a[]\\u7684\\u540Em\\u4E2A\\u5143\\u7D20\\u548Cb[]\\u5F00\\u5934\\u7684\\u524Dm\\u4E2A\\u5143\\u7D20\\u987A\\u5E8F\\u76F8\\u540C\\u65F6\\u63D0\\u4F9B\\u4E0B\\u6807\\u7684\\u670D\\u52A1 \\n    }\\n    if ( j==n+1 ) return i-n;\\/\\/i\\u662F\\u5F53\\u524D\\u70B9\\uFF0Cn\\u662Fb[]\\u7684\\u957F\\u5EA6\\uFF0C\\u8FD4\\u56DE\\u7684\\u662F\\u521D\\u59CB\\u70B9 \\n        else return -1;\\/\\/j==n+1\\u7684\\u539F\\u56E0\\u662Fa[]\\u90FD\\u88AB\\u904D\\u5386\\u5B8C\\u4E86\\uFF0C\\u800Cb[]\\u4ECD\\u672A\\u904D\\u5386\\u5B8C\\n        \\/\\/\\u53EA\\u6709\\u5F53b[]\\u90FD\\u88AB\\u904D\\u5386\\u5B8C\\u4E86\\u624D\\u7B97\\u5B8C\\u6574\\u7ED3\\u675F \\n}\\n\\n\\nint main(void)\\n{\\n    scanf(\\\"%d\\\", &repeat);\\n    while ( repeat-- )\\n    {\\n        scanf(\\\"%I64d%d\\\",&m ,&n);\\n        for ( i=1 ; i<=m ; i++ )\\n        {\\n            scanf(\\\"%d\\\", &a[i]);\\n        }\\n        for ( i=1 ; i<=n ; i++ )\\n        {\\n            scanf(\\\"%d\\\", &b[i]);\\n        }\\n        makeNext();\\n        cout<<kmp()<<endl;\\n    }\\n    return 0;\\n}\\\"}";
        System.out.println(JSONObject.parseObject(str));
    }
}
