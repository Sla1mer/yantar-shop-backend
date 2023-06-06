FROM gradle:jdk17

WORKDIR /yantar-shop-backend

COPY . /yantar-shop-backend

CMD ["gradle", "bootRun"]