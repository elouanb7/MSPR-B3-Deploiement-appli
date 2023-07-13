<template>
  <div class="container">
    <div class="users">
      <div
        v-for="conversation in conversations"
        :key="conversation.id"
        class="user"
        @click="selectConversation(conversation.id)"
      >
        <img src="https://picsum.photos/200" alt="avatar" class="user-avatar" />
        <span class="user-name">
          {{ getOtherUserName(conversation) }}
        </span>
      </div>
    </div>
    <div class="messages" v-if="selectedConversation" ref="messagesContainer">
      <div v-for="message in messages" :key="message.id">
        <div class="message-container1" v-if="isOtherUserMessage(message)">
          <span class="message-user-name1">
            {{ getOtherUserName(selectedConversation) }}
          </span>
          <div class="message-user1">
            <p>{{ message.content }}</p>
          </div>
        </div>
        <div class="message-container2" v-else>
          <span class="message-user-name2">Moi</span>
          <div class="message-user2">
            <p>{{ message.content }}</p>
          </div>
        </div>
      </div>
      <div class="saisie-container">
        <input
          type="text"
          placeholder="Envoyer un message"
          class="saisie-message"
          v-model="messageContent"
        />
        <button @click="sendMessage">Send</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { API_BASE_URL } from "@/constants";
import { useUserStore } from "@/stores/user";

export default {
  data() {
    return {
      selectedConversationId: null,
      conversations: null,
      userStore: useUserStore(),
      messageContent: null,
      messages: null,
    };
  },
  created() {
    this.fetchUserConversations().then(() => {
      if (this.conversations && this.conversations.length > 0) {
        this.selectedConversationId = this.conversations[0].id;
        this.fetchConversationMessage();
      }
    });
    setInterval(() => {
      this.fetchConversationMessage();
    }, 20000);
  },
  methods: {
    selectConversation(id) {
      this.selectedConversationId = id;
      this.fetchConversationMessage();
    },
    sendMessage() {
      const content = this.messageContent; // Assuming you have a data property called "messageContent" bound to the input field
      const conversationId = this.selectedConversationId; // Get the selected conversation ID
      const userId = this.userStore.id; // Get the user ID

      const message = {
        content,
        isRead: false,
      };

      // Make the POST request to send the message
      axios
        .post(`${API_BASE_URL}/message/send`, message, {
          params: {
            conversationId: conversationId,
            userId: userId,
          },
        })
        .then((response) => {
          // Handle the success response, e.g., update the messages list
          console.log("Message sent:", response.data);
          this.fetchConversationMessage();
          this.messageContent = ""; // Clear the input field
        })
        .catch((error) => {
          // Handle the error
          console.error("Error sending message:", error);
        });
    },
    fetchUserConversations() {
      return new Promise((resolve, reject) => {
        axios
          .get(`${API_BASE_URL}/conversations/user/${this.userStore.id}`)
          .then((response) => {
            this.conversations = response.data;
            resolve();
          })
          .catch((error) => {
            if (
              error.response &&
              (error.response.status === 401 || error.response.status === 403)
            ) {
              console.log("401 or 403");
            } else {
              console.error(error);
            }
            reject(error);
          });
      });
    },
    isOtherUserMessage(message) {
      return message.sender.id !== this.userStore.id;
    },
    fetchConversationMessage() {
      return new Promise((resolve, reject) => {
        axios
          .get(
            `${API_BASE_URL}/conversation/${this.selectedConversationId}/messages`
          )
          .then((response) => {
            this.messages = response.data;
            resolve();
          })
          .catch((error) => {
            if (
              error.response &&
              (error.response.status === 401 || error.response.status === 403)
            ) {
              console.log("401 or 403");
            } else {
              console.error(error);
            }
            reject(error);
          });
      });
    },
  },
  computed: {
    selectedConversation() {
      if (this.conversations && this.conversations.length > 0) {
        return this.conversations.find(
          (conversation) => conversation.id === this.selectedConversationId
        );
      }
      return null;
    },
    getOtherUserName() {
      return (conversation) => {
        if (conversation.user1.id === this.userStore.id) {
          return (
            conversation.user2.firstName + " " + conversation.user2.lastName
          );
        } else {
          return (
            conversation.user1.firstName + " " + conversation.user1.lastName
          );
        }
      };
    },
  },
};
</script>

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
  cursor: pointer;
}

.user-name {
  font-weight: bold;
  font-size: 14px;
  cursor: pointer;
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
