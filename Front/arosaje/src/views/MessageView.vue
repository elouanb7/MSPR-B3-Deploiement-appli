<template>
    <div class="container">
        <div class="users">
            <div class="user" @click="selectUser('Utilisateur 1')">
                <img src="http://fakeimg.pl/300/" alt="User 1" class="user-avatar" />
                <span class="user-name">Utilisateur 1</span>
            </div>
            
            <div class="user" @click="selectUser('Utilisateur 2')">
                <img src="http://fakeimg.pl/250x100/" alt="User 2" class="user-avatar" />
                <span class="user-name">Utilisateur 2</span>
            </div>
        </div>

        <div class="messages">
            <div class="message-container1" v-if="selectedUserName === 'Utilisateur 1'">
                <span class="message-user-name1">{{ selectedUserName }}</span>
                <div class="message-user1">
                    <p>Salut comment tu vas ?</p>
                </div>
            </div>

            <div class="message-container1" v-if="selectedUserName === 'Utilisateur 2'">
                <span class="message-user-name1">{{ selectedUserName }}</span>
                <div class="message-user1">
                    <p>Hello everybody !</p>
                </div>
            </div>

            <div class="message-container2">
                <span class="message-user-name2">Moi</span>
                <div class="message-user2">
                    <p>Très bien et toi ?</p>
                </div>
            </div>

            <div class="saisie-container">
                <input type="text" placeholder="Envoyer un message" class="saisie-message" />
            </div>
        </div>
    </div>
</template>
  
<style scoped>
body {
    overflow: hidden;
}

.container {
    display: flex;
    flex-direction: row;
    align-items: stretch;
    justify-content: flex-start;
    height: 100vh;
    padding: 30px 200px 0px 200px;
    overflow: hidden;
}

.users {
    flex: 1;
    display: flex;
    flex-direction: column;
    align-items: flex-end;
    padding-right: 30px;
    overflow-y: auto;
    border-right: 1px solid #ccc;
    overflow-y: auto;
}

.user {
    display: flex;
    align-items: center;
    margin-bottom: 30px;
}

.user-avatar {
    width: 40px;
    height: 40px;
    border-radius: 50%;
    object-fit: cover;
    margin-right: 10px;
}

.user-name {
    font-weight: bold;
    font-size: 14px;
}

.messages {
    flex-grow: 1;
    display: flex;
    flex-direction: column;
    min-height: 3000px;
    margin-left: 30px;
    overflow-y: auto;
}

.selected-user {
    font-weight: bold;
    font-size: 16px;
    margin-bottom: 10px;
}

.message-container1 {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    margin-bottom: 15px;
}

.message-container2 {
    display: flex;
    flex-direction: column;
    align-items: flex-end;
    margin-bottom: 15px;
}

.message-user1 {
    width: 210px;
    background: #fafafa;
    border: 1px solid #060825;
    box-shadow: 0px 15px 35px rgba(6, 8, 37, 0.2);
    border-radius: 30px;
    font-weight: 500;
    font-size: 12px;
    line-height: 15px;
    text-align: center;
    color: rgba(6, 8, 37, 0.5);
    padding: 15px;
}

.message-user2 {
    width: 210px;
    background: #060825;
    box-shadow: 0px 15px 35px rgba(6, 8, 37, 0.2);
    border-radius: 30px;
    font-weight: 500;
    font-size: 12px;
    line-height: 15px;
    text-align: center;
    color: #fafafa;
    padding: 15px;
}

.message-user-name1 {
    font-weight: bold;
    font-size: 10px;
    line-height: 12px;
    margin-left: 20px;
    margin-bottom: 5px;
}

.message-user-name2 {
    font-weight: bold;
    font-size: 10px;
    line-height: 12px;
    margin-right: 20px;
    margin-bottom: 5px;
}

.saisie-container {
    display: flex;
    justify-content: flex-end;
    position: fixed;
    bottom: 0;
    left: 0;
    width: 100%;
    padding: 0px 200px 0px 200px;
}

.saisie-message {
    width: 50%;
    height: 60px;
    background: #ffffff;
    border: 1px solid #060825;
    border-radius: 5px;
    font-family: "Montserrat";
    font-weight: 500;
    font-size: 16px;
    line-height: 20px;
    color: #060825;
    padding: 15px;
    margin: 5px;
}
</style>
  
<script>
export default {
    data() {
        return {
            selectedUserName: null,
        };
    },
    methods: {
        selectUser(userName) {
            this.selectedUserName = userName;
        },
    },
};
</script>