FROM nginx:1.18.0

RUN apt-get update
RUN apt-get install -y wget

RUN wget https://github.com/progrium/entrykit/releases/download/v0.4.0/entrykit_0.4.0_linux_x86_64.tgz
RUN tar -xvzf entrykit_0.4.0_linux_x86_64.tgz
RUN rm entrykit_0.4.0_linux_x86_64.tgz
RUN mv entrykit /usr/local/bin/
RUN entrykit --symlink

#conf.dのデフォルトファイルを全削除して各種設定ファイルをコピー
RUN rm /etc/nginx/conf.d/*
COPY ./conf.d/nginx.conf.tmpl /etc/nginx/
COPY ./conf.d/ /etc/nginx/conf.d/

#entrykitでテンプレートから設定ファイルを生成
ENTRYPOINT ["render", "/etc/nginx/nginx.conf", "--", "render", "/etc/nginx/conf.d/public.conf", "--" ]

CMD ["nginx", "-g", "daemon off;"]