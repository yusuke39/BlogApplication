FROM node:lts-alpine

WORKDIR /app

COPY ./web/package*.json ./

RUN npm install
 
RUN npm install element-ui

COPY ./web .

CMD ["npm", "run", "serve"]